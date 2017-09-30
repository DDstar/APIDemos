package android.view;

/**
 * Created by prize on 2017/9/30.
 */

public class FViewGroup extends FView{


    protected FViewGroup.FOnHierarchyChangeListener mOnHierarchyChangeListener;


    public void setOnHierarchyChangeListener(FViewGroup.FOnHierarchyChangeListener listener) {
        mOnHierarchyChangeListener = listener;
    }

    public interface FOnHierarchyChangeListener {

        void onChildViewAdded(FView parent, FView child);


        void onChildViewRemoved(FView parent, FView child);
    }

}
