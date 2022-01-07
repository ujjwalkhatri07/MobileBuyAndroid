package com.ujjwal.mobileShop.fragments

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ujjwal.mobileShop.R

class MapsFragment : Fragment() {
    private val callback = OnMapReadyCallback { googleMap ->

        val SnehaCare = LatLng(27.6518687, 85.2904712)
        googleMap.addMarker(MarkerOptions().position(SnehaCare).title("Mobile Shop"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SnehaCare, 15F), 4000, null )
        googleMap.uiSettings.isZoomControlsEnabled = true
//        googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID;
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }}