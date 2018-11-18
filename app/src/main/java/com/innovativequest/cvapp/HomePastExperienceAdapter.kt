package com.innovativequest.cvapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.innovativequest.cvapp.Utils.Utils
import com.innovativequest.cvapp.models.ExperiencesItem
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


class  HomePastExperienceAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    lateinit internal var experience: ExperiencesItem
    internal var mItemList: MutableList<ExperiencesItem> = ArrayList()
    private var lastSelectedPosition = -1

    val clickSubject = PublishSubject.create<ExperiencesItem>()
    val clickEvent: Observable<ExperiencesItem> = clickSubject

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.experience_item_recycler_row, parent,false)
        return ExperienceItemViewHolder(rootView)
    }
    override fun getItemCount(): Int {
        return mItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ExperienceItemViewHolder).bindNearMeDeskData(mItemList.get(position), position)
    }


    internal fun setData(experienceList: List<ExperiencesItem>){
        mItemList.clear()
        mItemList.addAll(experienceList)
        notifyDataSetChanged()
    }

    inner class ExperienceItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        private var currentPosition = 0
        lateinit internal var experience: ExperiencesItem

        @BindView(R.id.title_tv)
        lateinit internal var titleTv: TextView

        @BindView(R.id.job_title_tv)
        lateinit internal var jobTitleTv: TextView

        @BindView(R.id.achievements_tv)
        lateinit internal var achievementsTv: TextView

        init {
            ButterKnife.bind(this,view)
        }

        fun bindNearMeDeskData(experiencesItem: ExperiencesItem, currentPosition: Int) {
            this.experience = experiencesItem
            this.currentPosition = currentPosition

            try {
                titleTv.text = experiencesItem.title + "\n" + Utils.getDateInDisplayableFormat(experiencesItem.startDate!!) + " to " + Utils.getDateInDisplayableFormat(experiencesItem.endDate!!)
                jobTitleTv.text = experiencesItem.jobTitle
                achievementsTv.text = experiencesItem.achievements
            }
            catch (e: NullPointerException){
                e.printStackTrace()
            }
        }

    }
    companion object {

    }
}