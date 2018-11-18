package com.innovativequest.cvapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.innovativequest.cvapp.Utils.Utils
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : Fragment() {

    @BindView(R.id.name_tv)
    lateinit internal var nameTv: TextView

    @BindView(R.id.person_iv)
    lateinit internal var personIv: ImageView

    @BindView(R.id.summary_tv)
    lateinit internal var summaryTv: TextView

    @BindView(R.id.technical_knowledge_tv)
    lateinit internal var technicalKnowledgeTv: TextView

    @BindView(R.id.past_experience_recycler_view)
    lateinit internal var pastExperienceRecyclerView: RecyclerView

    lateinit internal var mAdapter: HomePastExperienceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        ButterKnife.bind(this,view)


        mAdapter = HomePastExperienceAdapter()
        pastExperienceRecyclerView.layoutManager = LinearLayoutManager(activity)
        pastExperienceRecyclerView.adapter = mAdapter

        var json = Utils.getJsonFromAssetPath("fakedata/person.json", activity!!.applicationContext)
        if(json!=null){
            val person = Utils.personFromJson(json)
            try {
                Picasso.get().load(person.imageUrl).into(personIv, object : Callback {
                    override fun onSuccess() { }
                    override fun onError(e: Exception?) {
                        if(e!=null) e.printStackTrace()
                    }
                })


                nameTv.text                 = person.name
                summaryTv.text              = person.summary
                technicalKnowledgeTv.text   = person.technicalKnowledge
            }
            catch (e:NullPointerException){
                e.printStackTrace()
            }
        }

        json = Utils.getJsonFromAssetPath("fakedata/experiences.json", activity!!.applicationContext)
        if(json!=null){
            val experiences = Utils.experiencesFromJson(json)
            if(experiences.experienceItems!=null)
                mAdapter.setData(experiences.experienceItems)
        }




        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment
         *
         * @return A new instance of fragment HomeFragment.
         */
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
