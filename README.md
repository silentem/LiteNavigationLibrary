# Lite Navigation Library

# How to use
1) Add library via dependency

```
dependencies { compile 'com.github.silentem:LiteNavigationLibrary:LATEST_VERSION' }
```

2) Add a views to your layout

```xml
    <com.whaletail.lite.views.LiteGeneralHolder
        android:id="@+id/lgh_general"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_above="@+id/lbn_general" />

    <com.whaletail.lite.views.LiteBottomNavigator
        android:id="@+id/lbn_general"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:layout_alignParentBottom="true"
        android:background="@color/colorBlack" />
        
  ```
  
  3) Use Api to create navigator with holder
  
  ```java
 
        Lite.builder(getSupportFragmentManager())
                .navigator(bottom)
                .holder(viewPager)
                .page(new LiteFragmentListener() {

                    private boolean shouldClick = false;

                    private boolean isShouldClick() {
                        return shouldClick;
                    }

                    private void setShouldClick(boolean shouldClick) {
                        this.shouldClick = shouldClick;
                    }

                    @NonNull
                    @Override
                    public Fragment getFragment() {
                        Log.i(TAG, "onClick triggered");
                        return new LiteFragment();
                    }

                    @Override
                    public boolean onPreGetFragment(final int position) {
                        Log.i(TAG, "position: " + position);

                        new Button(MainActivityExample.this).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setShouldClick(true);
                                bottom.setCurrentPosition(position);

                            }
                        });

                        return isShouldClick();
                    }
                })
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
                .page(new LiteFragment())
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
                .page(new LiteFragment())
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
                .page(new LiteFragment())
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
                .page(new LiteFragment())
                .icons(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round)
                .switchListener(new SwitchListener() {
                    @Override
                    public void onSwitch() {
                        Log.i(TAG, "onSwitch triggered");
                    }
                })
                .build();
                
```

