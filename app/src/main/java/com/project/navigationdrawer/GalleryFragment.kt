package com.project.navigationdrawer

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GalleryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GalleryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var gridView: GridView
    val modalList = ArrayList<Modal>()
    var names = arrayOf("grocery", "drinks", "fruits")
    var images = intArrayOf(
        R.drawable.grocery_3,
        R.drawable.grocery_drinks,
        R.drawable.grocery_fruits,
        R.drawable.grocery_oil1,
        R.drawable.groceryveg,
        R.drawable.grocery_milk
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }




    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val rootView:View=inflater.inflate(R.layout.fragment_gallery, container, false)
        gridView = rootView.findViewById(R.id.gridView)
     for(i in names.indices){
         modalList.add(Modal(names[i],images[i]))
     }
        var customAdapter = CustomAdapter(modalList,requireContext())
        gridView.adapter = customAdapter;

       // gridView.setAdapter(new CustomGridAdpater(GalleryFragment@this,items))
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_gallery, container, false)
        return  rootView

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GalleryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GalleryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    class CustomAdapter(
        var itemModel: ArrayList<Modal>, var context: Context
    ):BaseAdapter(){
      //  var layoutInflater = ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE)  as LayoutInflater

        var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


        override fun getCount(): Int {
           return itemModel.size
        }

        override fun getItem(position: Int): Any {
          return itemModel[position]
        }

        override fun getItemId(position: Int): Long {
            return  position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var view = convertView;

            if(view == null){
                view = inflater.inflate(R.layout.row_items,parent,false)
            }
            var  ImageName = view?.findViewById<ImageView>(R.id.imageName)
            ImageName?.setImageResource(itemModel[position].image!!)

            return view!!;
        }

    }

}