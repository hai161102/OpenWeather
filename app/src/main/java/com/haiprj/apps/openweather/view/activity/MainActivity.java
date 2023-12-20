package com.haiprj.apps.openweather.view.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.haiprj.apps.openweather.App;
import com.haiprj.apps.openweather.Const;
import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.api.ApiConfigs;
import com.haiprj.apps.openweather.api.result.Coord;
import com.haiprj.apps.openweather.api.result.CurrentWeatherData;
import com.haiprj.apps.openweather.base.BaseActivity;
import com.haiprj.apps.openweather.databinding.ActivityMainBinding;
import com.haiprj.apps.openweather.model.Coordinate;
import com.haiprj.apps.openweather.model.CoordinateFavorite;
import com.haiprj.apps.openweather.room.AppDatabase;
import com.haiprj.apps.openweather.utils.AppUtils;
import com.haiprj.apps.openweather.utils.SharePreferenceUtil;
import com.haiprj.apps.openweather.view.adapter.ViewPagerAdapter;
import com.haiprj.apps.openweather.view.fragment.MainWeatherFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    private final ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            MainWeatherFragment fragment = MainActivity.this
                    .mainWeatherFragmentViewPagerAdapter
                    .createFragment(position);
            Coord coord = fragment.getCoord();
            ApiConfigs.getInstance().apiServices.getCurrentWeatherData(
                    coord.getLat(),
                    coord.getLon(),
                    ApiConfigs.API_KEY,
                    "vi"
            ).enqueue(new Callback<CurrentWeatherData>() {
                @Override
                public void onResponse(@NonNull Call<CurrentWeatherData> call, @NonNull Response<CurrentWeatherData> response) {
                    System.out.println(response);
                    if (response.isSuccessful() && response.body() != null) {
                        MainActivity.this.setTitle(response.body());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<CurrentWeatherData> call, @NonNull Throwable t) {
                    System.out.println(t.getMessage());
                }
            });
            boolean isTempC = SharePreferenceUtil.getInstance().getSharedPreferences().getBoolean(Const.TEMP_UNIT_KEY, true);
            if (isTempC != fragment.isTempC()) {
                fragment.reloadData();
                fragment.setTempC(isTempC);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);

        }
    };

    public static Location currentLocation;
    private MainWeatherFragment currentLocationFragment;
    public static final List<String> listGrantedPermission = new ArrayList<>();
    public final List<MainWeatherFragment> weatherFragmentList = new ArrayList<>();
    private ViewPagerAdapter<MainWeatherFragment> mainWeatherFragmentViewPagerAdapter;

    @Override
    protected void initView() {

        this.binding.navSettings.switchTempIcon.setImageResource(
                SharePreferenceUtil.getInstance().getSharedPreferences().getBoolean(Const.TEMP_UNIT_KEY, true)
                        ? R.drawable.switch_c
                        : R.drawable.switch_f
        );
        this.mainWeatherFragmentViewPagerAdapter = new ViewPagerAdapter<>(this);
        this.binding.mainView.viewpager.setAdapter(mainWeatherFragmentViewPagerAdapter);
        this.binding.mainView.viewpager.registerOnPageChangeCallback(onPageChangeCallback);
        this.loadListLocation(AppDatabase.getInstance().dataCoordinate().getAll());
        this.loadLocation();

        Date date = new Date();
        Locale locale = new Locale("vi");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("EE - MMMM dd, yyyy", locale);
        this.binding.mainView.currentDay.setText(dateFormat.format(date));
        if (App.getInstance().getFirebaseUser() != null) {
            binding.navSettings.username.setText(App.getInstance().getFirebaseUser().getEmail());
        }
        else {
            binding.navSettings.username.setText(R.string.no_account);
        }
    }

    @SuppressLint("MissingPermission")
    private void addLocation() {
        if (AppUtils.isGranted(this, Manifest.permission.ACCESS_FINE_LOCATION)
                && AppUtils.isGranted(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {

            LocationManager locationManager =
                    (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
            setCurrentLocation(locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                locationManager.getCurrentLocation(
                        LocationManager.GPS_PROVIDER,
                        null,
                        MainActivity.this.getApplication().getMainExecutor(),
                        location -> {
                            if (location != null) {
                                setCurrentLocation(location);
                            }
                        }
                );
            }

        }

    }

    @Override
    protected void initData() {
        binding.mainView.menu.setOnClickListener(v -> {
            if (!binding.drawerLayout.isDrawerOpen(binding.navView)) {
                binding.drawerLayout.openDrawer(binding.navView, true);
            } else {
                binding.drawerLayout.closeDrawer(binding.navView, true);
            }
        });
        binding.mainView.add.setOnClickListener(v -> {
            gotoManageLocation();
        });
        binding.navSettings.manageLocation.setOnClickListener(v -> {
            gotoManageLocation();
        });
        binding.navSettings.switchTemp.setOnClickListener(v -> {
            this.switchTemp();
        });
        binding.mainView.swipeRefresh.setOnRefreshListener(() -> {
            this.mainWeatherFragmentViewPagerAdapter.createFragment(
                    binding.mainView.viewpager.getCurrentItem()
            ).reloadData();
            this.binding.mainView.swipeRefresh.setRefreshing(false);
        });
        binding.navSettings.favLoc.setOnClickListener(v -> {
            startActivityForResult(new Intent(this, FavoriteActivity.class), 103);
        });
        binding.navSettings.addFavLoc.setOnClickListener(v -> {
            Coord coord = getCurrentFragment().getCoord();
            CoordinateFavorite coordinate = new CoordinateFavorite();
            coordinate.setLon(coord.getLon());
            coordinate.setLat(coord.getLat());
            AppDatabase.getInstance().dataCoordinateFavorite().insert(coordinate);
            Toast.makeText(this, "Đã thêm " + getCurrentFragment().getCurrentWeatherData().getName() +" vào yêu thích", Toast.LENGTH_LONG).show();
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void switchTemp() {
        boolean c = SharePreferenceUtil.getInstance().getSharedPreferences().getBoolean(Const.TEMP_UNIT_KEY, true);
        if (c) {
            this.binding.navSettings.switchTempIcon.setImageResource(R.drawable.switch_f);
        } else {
            this.binding.navSettings.switchTempIcon.setImageResource(R.drawable.switch_c);
        }
        SharePreferenceUtil.getInstance().put(Const.TEMP_UNIT_KEY, !c);
        getCurrentFragment().reloadData();
    }

    private void gotoManageLocation() {
        this.startActivityForResult(new Intent(this, ManageLocationActivity.class), 102);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            this.loadLocation();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 102 && resultCode == RESULT_OK) {
            this.binding.drawerLayout.closeDrawer(this.binding.navView, true);
            this.loadListLocation(AppDatabase.getInstance().dataCoordinate().getAll());
            if (data != null) {
                Coord coord = (Coord) data.getSerializableExtra(ManageLocationActivity.SEARCH_RESULT);
                if (coord != null) {
                    for (int i = 0; i < mainWeatherFragmentViewPagerAdapter.getItemCount(); i++) {
                        Coord c = mainWeatherFragmentViewPagerAdapter.createFragment(i).getCoord();
                        if (Objects.equals(c.getLat(), coord.getLat()) && Objects.equals(c.getLon(), coord.getLon())) {
                            this.binding.mainView.viewpager.setCurrentItem(i, true);
                            return;
                        }
                    }
                }
            }
        }
        if (requestCode == 103 && resultCode == RESULT_OK) {
            this.binding.drawerLayout.closeDrawer(this.binding.navView, true);
            if (data != null) {
                Coord coord = (Coord) data.getSerializableExtra(FavoriteActivity.ONCLICK_FAVORITE);
                if (coord != null) {
                    for (int i = 0; i < mainWeatherFragmentViewPagerAdapter.getItemCount(); i++) {
                        Coord c = mainWeatherFragmentViewPagerAdapter.createFragment(i).getCoord();
                        if (Objects.equals(c.getLat(), coord.getLat()) && Objects.equals(c.getLon(), coord.getLon())) {
                            this.binding.mainView.viewpager.setCurrentItem(i, true);
                            return;
                        }
                    }
                }
            }
        }
    }

    private MainWeatherFragment getCurrentFragment() {
        return mainWeatherFragmentViewPagerAdapter.createFragment(this.binding.mainView.viewpager.getCurrentItem());
    }
    public void queryCurrentLocationWeather() {
        if (currentLocation != null) {
            Coord coord = new Coord();
            coord.setLat(currentLocation.getLatitude());
            coord.setLon(currentLocation.getLongitude());
            if (currentLocationFragment != null) {
                mainWeatherFragmentViewPagerAdapter.remove(currentLocationFragment);
            }
            currentLocationFragment = new MainWeatherFragment(this, coord);
            MainActivity.this.binding.mainView.viewpager.setCurrentItem(0);

            this.mainWeatherFragmentViewPagerAdapter.add(0, currentLocationFragment);
        }
    }

    public void setTitle(
            CurrentWeatherData currentWeatherData) {
        binding.mainView.locationName.setText(currentWeatherData.getName());
    }

    public void setCurrentLocation(Location location) {
        MainActivity.currentLocation = location;
        this.queryCurrentLocationWeather();

    }

    public void loadLocation() {
        listGrantedPermission.clear();
        listGrantedPermission.addAll(
                AppUtils.requestPermission(MainActivity.this, 101)
        );
        if (listGrantedPermission.size() == 2) {
            addLocation();
        }
    }

    public void loadListLocation(List<Coordinate> coords) {
        mainWeatherFragmentViewPagerAdapter.removes(weatherFragmentList);
        weatherFragmentList.clear();
        coords.forEach(coord -> {
            Coord c = new Coord();
            c.setLat(coord.getLat());
            c.setLon(coord.getLon());
            MainWeatherFragment mainWeatherFragment = new MainWeatherFragment(this, c);
            mainWeatherFragment.setOnLoadDone(new MainWeatherFragment.OnLoadDone() {
                @Override
                public void onDoneCurrent(CurrentWeatherData currentWeatherData) {
                    mainWeatherFragmentViewPagerAdapter.notifyItemChanged(
                            mainWeatherFragmentViewPagerAdapter.getList().indexOf(mainWeatherFragment)
                    );
                }
            });
            weatherFragmentList.add(mainWeatherFragment);
        });
        mainWeatherFragmentViewPagerAdapter.addAll(weatherFragmentList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding.mainView.viewpager.unregisterOnPageChangeCallback(onPageChangeCallback);
    }
}