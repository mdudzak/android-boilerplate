package sk.company.androidboilerplate.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_character.view.*
import sk.company.androidboilerplate.R
import sk.company.androidboilerplate.data.model.Character
import java.util.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var mCharacterList: ArrayList<Character> = ArrayList()
    val mOnClickSubject: PublishSubject<String> = PublishSubject.create()

    fun setList(characterList: List<Character>) {
        mCharacterList.addAll(characterList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainAdapter.ViewHolder {
        val v = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_character, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder?, position: Int) {
        val char: Character = mCharacterList[position]

        holder?.itemView?.title?.text = char.name

    }

    override fun getItemCount() = mCharacterList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}