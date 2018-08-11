package driverapp.vehiclemanager.com.vehiclemanager.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import driverapp.vehiclemanager.com.vehiclemanager.R;
import driverapp.vehiclemanager.com.vehiclemanager.datamodel.Place;

// here's our beautiful adapter
public class ArrayAdapterItem extends ArrayAdapter<Place> {

	Context mContext;
	int layoutResourceId;
	ArrayList<Place> data = null;
	TextView textView_Hospital_Location ;

	public ArrayAdapterItem(Context mContext, int layoutResourceId,
			ArrayList<Place> data) {

		super(mContext, layoutResourceId, data);

		this.layoutResourceId = layoutResourceId;
		this.mContext = mContext;
		this.data = data;
	}

	/*
	 * public ArrayAdapterItem sortData() { Collections.sort(data); return this;
	 * }
	 */
	@SuppressWarnings("null")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		/*
		 * The convertView argument is essentially a "ScrapView" as described is
		 * Lucas post
		 * http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
		 * It will have a non-null value when ListView is asking you recycle the
		 * row layout. So, when convertView is not null, you should simply
		 * update its contents instead of inflating a new row layout.
		 */
		if (convertView == null) {
			// inflate the layout
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(layoutResourceId, parent, false);
		}

		// object item based on the position
		

		// get the TextView and then set the text (item name) and tag (item ID)
		// values
		

		TextView textView_Place_Name = (TextView) convertView
				.findViewById(R.id.textView1_Place_Name);
		textView_Place_Name.setText(data.get(position).getName());
		//textView_Hospital_Name.setText("Hospital Name");
		
		//textView_Hospital_Location  = (TextView) convertView.findViewById(R.id.textView1_Location);
		
		//Geocoder geocoder = new Geocoder(mContext, Locale.getDefault()); 
		
		//Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());   
		
		//GetLocationTask getL = null;
		
		
//		Location location = null;
//		location.setLatitude(data.get(position).getLatitude());
//		location.setLongitude(data.get(position).getLongitude());
//		
//		getL.getAddressFromLocation(location, mContext, new GeocoderHandler());
//		
	//	new GetAddressTask(textView_Hospital_Location, geocoder,data.get(position).getLatitude(),data.get(position).getLongitude(), mContext).execute();
	     
		
		
		
//        String result = null;
//        try {
//            List<Address> list = geocoder.getFromLocation(
//                    data.get(position).getLatitude(), data.get(position).getLongitude(), 1);
//            if (list != null && list.size() > 0) 
//                {
//                Address address = list.get(0);
//                // sending back first address line and locality
//                result = address.getAddressLine(0) + ", " + address.getLocality()+","+address.getCountryName();
//                    }
//            } 
//         catch (IOException e)
//            {
//            Log.e("TAG", "Impossible to connect to Geocoder", e);
//            } 
//         textView_Hospital_Location.setText(result);
//        
//        
//       
//		//if(data.get(position).getAddress(geocoder).equalsIgnoreCase("") || data.get(position).getAddress(geocoder).equalsIgnoreCase(null))
//		if(result.equalsIgnoreCase(null))
//         {
//			 textView_Hospital_Location.setText("Address is unavailable");
//		       
//		}
//		else 
//       textView_Hospital_Location.setText(result);
//        
       

        
		return convertView;

	}
	
	public ArrayList<Place> getData() {
		return data;
	}
	
//	private class GeocoderHandler extends Handler {
//	    @Override
//	    public void handleMessage(Message message) {
//	        String result;
//	        switch (message.what) {
//	        case 1:
//	            Bundle bundle = message.getData();
//	            result = bundle.getString("address");
//	            break;
//	        default:
//	            result = null;
//	        }
//	        // replace by what you need to do
//	       textView_Hospital_Location.setText(result);
//	    }   
//	}
	
	

}