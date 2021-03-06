package com.afpa.androidlistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import model.UserAccount;

public class CustomListAdapter extends BaseAdapter {

    private List<UserAccount> users;
    private LayoutInflater layoutInflater;
    private Context context;

    static class ViewHolder{
        ImageView rolePicView;
        TextView userNameView;
        TextView roleView;
    }

    /**
     * Constructeur à 2 paramètres
     * @param users
     * @param context
     */

    public CustomListAdapter(List<UserAccount> users, Context context) {
        this.users = users;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("unliste", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int positon, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.liste_item_layout,null);
            holder = new ViewHolder();
            holder.rolePicView = (ImageView) convertView.findViewById(R.id.imageView_role);
            holder.userNameView = (TextView) convertView.findViewById(R.id.textView_name);
            holder.roleView = (TextView) convertView.findViewById(R.id.textView_role);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        UserAccount user = this.users.get(positon);
        holder.userNameView.setText(user.getUserName());
        holder.roleView.setText("Role: "+ user.getUserType());

        int imageId = this.getMipmapResIdByName(user.getUserType());

        holder.rolePicView.setImageResource(imageId);
        return convertView;
    }

}
