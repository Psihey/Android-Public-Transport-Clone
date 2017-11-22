package com.provectus.public_transport.utils;


import com.google.android.gms.maps.model.LatLng;
import com.provectus.public_transport.PublicTransportApplication;
import com.provectus.public_transport.R;

public final class Const {

    private Const() {
    }

    public static class DefaultCameraPosition {
        private DefaultCameraPosition() {

        }

        public static final LatLng ODESSA_FIRST_POINTS = new LatLng(46.348612, 30.671341);
        public static final LatLng ODESSA_SECOND_POINTS = new LatLng(46.499907, 30.781572);
        public static final int ZOOM_ON_MAP = 30;
    }

    public static class TransportType {
        private TransportType(){

        }

        public static final String TRAMS = PublicTransportApplication.getContext().getString(R.string.transport_type_tram);
        public static final int TRAMS_ADAPTER = 1;
        public static final String TROLLEYBUSES = PublicTransportApplication.getContext().getString(R.string.transport_type_trolleybus);
        public static final int TROLLEYBUSES_ADAPTER = 2;
    }

}
