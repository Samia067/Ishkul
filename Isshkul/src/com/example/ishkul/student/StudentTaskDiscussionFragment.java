package com.example.ishkul.student;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isshkul.R;

public class StudentTaskDiscussionFragment extends Fragment{

	Context context ;
	ArrayList<DiscussionCommentModel> discussionItems;
	
	Button sendButton;
	public StudentTaskDiscussionFragment() {
		super();
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		context = getActivity();

		View view = inflater.inflate(R.layout.fragment_student_task_discussion, container , false);
        //sendButton = (Button) view.findViewById(R.id.sendButton);
//        ((Button) sendButton).setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(StudentTaskDiscussionFragment.this.getActivity().getBaseContext(),
//                        "clicked on Send Button", Toast.LENGTH_SHORT).show();
//
////                Intent intent = new Intent();
////                intent.setClass(getActivity(), RetrieveAthleteData.class);
////                startActivity(intent);
//            }
//        });
		
		
		discussionItems = new ArrayList<DiscussionCommentModel>() ;

		//using arguments passed to fragments
		//		TextView dummyTextView = (TextView) rootView
		//				.findViewById(R.id.section_label);
		//		dummyTextView.setText(Integer.toString(getArguments().getInt(
		//				ARG_SECTION_NUMBER)));
		//		return rootView;

		discussionItems.add(new DiscussionCommentModel("Farzia Afroze", 1982, 8, 31, 10, 20, "Is chapter 5 important? Does anybody know?!"));
		discussionItems.add(new DiscussionCommentModel("Raisa Farzana", 1982, 8, 31, 10, 22, "I heard sir repeat it twice in class..."));
		discussionItems.add(new DiscussionCommentModel("Samia Shafique", 1982, 8, 31, 10, 24, "Sabbirer chotha is the solution"));
		discussionItems.add(new DiscussionCommentModel("Saad Nasik", 1982, 8, 31, 10, 25,  "Sabbirer chotha is the solution Sabbirer chotha is the solution Sabbirer chotha is the solution Sabbirer chotha is the solution Sabbirer chotha is the solution Sabbirer chotha is the solution Sabbirer chotha is the solutionSabbirer chotha is the solution Sabbirer chotha is the solution Sabbirer chotha is the solution Sabbirer chotha is the solution Sabbirer chotha is the solution"));

		
		
		ListView listview = (ListView) view.findViewById(R.id.student_task_discussion_listview);
		ListAdapter adapter = new ListAdapter();
		listview.setAdapter(adapter);
		
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Toast.makeText(getActivity(), "Item " + position + " Clicked" , Toast.LENGTH_SHORT).show();
			}
		});

		return view ;		
	}
	
	public class ListAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			
			return discussionItems.size() ;
		}

		@Override
		public Object getItem(int arg0) {			
			return discussionItems.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position , View view , ViewGroup parent) {
			
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.student_task_discussion_list_row, parent , false);
			
			DiscussionCommentModel dc =discussionItems.get(position); 
			TextView name = (TextView) view.findViewById(R.id.student_task_discussion_name_textview);
			name.setText(dc.name);

			TextView com = (TextView) view.findViewById(R.id.student_task_discussion_comment_textview);
			com.setText(dc.comment);

			TextView date = (TextView) view.findViewById(R.id.student_task_discussion_date_textview);
			date.setText(dc.getTime());
			
			return view;
		}
		
	} 

}