package com.example.testmap;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Circle;
import com.yandex.mapkit.geometry.LinearRing;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.geometry.Polygon;
import com.yandex.mapkit.geometry.Polyline;
import com.yandex.mapkit.map.CameraPosition;

import com.yandex.mapkit.map.CircleMapObject;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.PatternRepeatMode;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.mapkit.map.PolygonMapObject;
import com.yandex.mapkit.map.PolylineMapObject;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.runtime.image.AnimatedImageProvider;
import com.yandex.runtime.image.ImageProvider;
import com.yandex.runtime.ui_view.ViewProvider;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final String MAPKIT_API_KEY = "87cdeb65-699e-457f-9556-526e43c35303";
    private final Point CAMERA_TARGET = new Point(59.952, 30.318);
    private final Point ANIMATED_RECTANGLE_CENTER = new Point(59.956, 30.313);
    private final Point TRIANGLE_CENTER = new Point(59.948, 30.313);
    private final Point POLYLINE_CENTER = CAMERA_TARGET;
    private final Point CIRCLE_CENTER = new Point(59.956, 30.323);
    private final Point DRAGGABLE_PLACEMARK_CENTER = new Point(59.948, 30.323);
    private final double OBJECT_SIZE = 0.0015;

    private MapView mapView;
    private MapObjectCollection mapObjects;
    private Handler animationHandler;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);
        mapView = (MapView)findViewById(R.id.mapview);
        mapView.getMap().move(
                new CameraPosition(CAMERA_TARGET, 15.0f, 0.0f, 0.0f));
        mapObjects = mapView.getMap().getMapObjects().addCollection();
        animationHandler = new Handler();
        createMapObjects();

        button = findViewById(R.id.buttonMove);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Connect", "onClick: ");
            }
        });
    }

    @Override
    protected void onStop() {
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }

    private void createMapObjects() {
        AnimatedImageProvider animatedImage = AnimatedImageProvider.fromAsset(this, "animation.png");



        PlacemarkMapObject mark = mapObjects.addPlacemark(DRAGGABLE_PLACEMARK_CENTER);
        mark.setOpacity(0.5f);
        mark.setIcon(ImageProvider.fromResource(this, R.drawable.mark));
        mark.setDraggable(true);
    }
    private void moveMark(){

    }


    }


