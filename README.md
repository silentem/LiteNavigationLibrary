# Lite Navigation Library

# How to use
1) Copy sources to your project
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
  
  ```kotlin
  
        Lite.builder(supportFragmentManager)
                .navigator(lbn_general)
                .holder(lgh_general)
                .page(Fragment())
                .icon(R.mipmap.ic_home_active)
                .page(Fragment())
                .icons(R.mipmap.ic_store_active, R.mipmap.ic_store_no_active)
                .page(Fragment())
                .icons(R.mipmap.ic_cart_active, R.mipmap.ic_cart_no_active)
                .build()
                
```
