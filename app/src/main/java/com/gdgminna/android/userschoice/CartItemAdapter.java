package com.gdgminna.android.userschoice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.tonyvu.sc.model.Cart;
import com.android.tonyvu.sc.model.Saleable;
import com.android.tonyvu.sc.util.CartHelper;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CartItemAdapter extends BaseAdapter {

    private static final String TAG = "CartItemAdapter";


    private List<CartItem> cartItems = Collections.emptyList();

    private final Context context;

    public CartItemAdapter(Context context) {
        this.context = context;
    }

    public void updateCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return cartItems.size();
    }

    @Override
    public CartItem getItem(int position) {
        return cartItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TextView Name;
        TextView UnitPrice;
        TextView Quantity;
        TextView Price;
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.cart_item_adapter, parent, false);
            Name = convertView.findViewById(R.id.name);
            UnitPrice = convertView.findViewById(R.id.unit_price);
            Quantity = convertView.findViewById(R.id.quantity);
            Price = convertView.findViewById(R.id.total_amount);
            convertView.setTag(new ViewHolder(Name, UnitPrice, Quantity, Price));
        } else {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            Name = viewHolder.CartItemName;
            UnitPrice = viewHolder.CartItemUnitPrice;
            Quantity = viewHolder.CartItemQuantity;
            Price = viewHolder.CartItemPrice;
        }

        final Cart cart = CartHelper.getCart();
        final CartItem cartItem = getItem(position);
        Name.setText(cartItem.getItem().getName());
        UnitPrice.setText(Constant.CURRENCY + String.valueOf(cartItem.getItem().getUnitPrice().setScale(0, BigDecimal.ROUND_HALF_UP)));
        Quantity.setText(String.valueOf(cartItem.getQuantity()));
        Price.setText(Constant.CURRENCY + String.valueOf(cart.getCost((Saleable) cartItem.getItem()).setScale(0, BigDecimal.ROUND_HALF_UP)));
        return convertView;
    }

    private static class ViewHolder {
        public final TextView CartItemName;
        public final TextView CartItemUnitPrice;
        public final TextView CartItemQuantity;
        public final TextView CartItemPrice;

        public ViewHolder(TextView CartItemName, TextView CartItemUnitPrice, TextView CartItemQuantity, TextView CartItemPrice) {
            this.CartItemName = CartItemName;
            this.CartItemUnitPrice = CartItemUnitPrice;
            this.CartItemQuantity = CartItemQuantity;
            this.CartItemPrice = CartItemPrice;
        }
    }
}

