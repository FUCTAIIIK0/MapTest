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
import android.widget.ImageView;
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
import com.yandex.mapkit.map.MapObject;
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
    private final Point CAMERA_TARGET = new Point(59.948, 30.3235);

    private final Point placemarkPointA = new Point(59.947, 30.323);
    private final Point placemarkPointB = new Point(59.948, 30.3235);
    private final Point placemarkPointC = new Point(59.949, 30.3235);
    private final Point placemarkPointD = new Point(59.95, 30.3235);

    private Point tempPlacemarkPoint = new Point();


    PlacemarkMapObject markA;
    PlacemarkMapObject markB;
    PlacemarkMapObject markA1;
    PlacemarkMapObject markB1;

    PlacemarkMapObject markC;

    private MapView mapView;
    private MapObjectCollection mapObjects;


    private Button button;
    private Button button1;

    Boolean fixButton = false;

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

        createMapObjects();

        button = findViewById(R.id.buttonMove);
        button1 = findViewById(R.id.buttonMove1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                moveMark(markA, placemarkPointC);
                Log.d("Connect", "Bt: ");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMark(markA,placemarkPointD);
                Log.d("Connect", "Bt1: ");
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
        markA = mapObjects.addPlacemark(placemarkPointA);
        markA.setOpacity(0.5f);
        markA.setIcon(ImageProvider.fromResource(this, R.drawable.mark));
        markA.setDraggable(false);

        markB = mapObjects.addPlacemark(placemarkPointB);
        markB.setOpacity(0.5f);
        markB.setIcon(ImageProvider.fromResource(this,R.drawable.mark));
    }

    private void moveMark(PlacemarkMapObject mark, Point point){
        mapObjects.remove(mark);

        mark = mapObjects.addPlacemark(new Point(point.getLatitude(),point.getLongitude()));
        mark.setOpacity(0.5f);
        mark.setIcon(ImageProvider.fromResource(this,R.drawable.mark));

        runOnUiThread(() -> {

        });


        }
    }



