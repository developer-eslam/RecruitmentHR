package com.erp.recruitmentmanagment.recruitmentsystem.personalapplcation;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.erp.recruitmentmanagment.recruitmentsystem.R;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abotaleb on 12/8/2016.
 */

public class detailsfragmentthree_rececleeview   extends RecyclerView.Adapter<detailsfragmentthree_rececleeview.Holder> {

    EditText textIn;
    Button buttonAdd;
    Button removebtn;
    Button  createpdf;
    Button  openpdf;
    LinearLayout container;
    private List<personalappliactionmodel> personalappliactionmodels;
    Context context;
    EditText text;
    View addView;
    CheckBox male,female;
    int j=0;
    int N;
    int u = 0;
    int i;

    public detailsfragmentthree_rececleeview( Context context,List<personalappliactionmodel>personalappliactionmodels){
        this.personalappliactionmodels=personalappliactionmodels;
        this.context = context;

    }
    @Override
    public detailsfragmentthree_rececleeview.Holder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.details_fragment_there,parent,false);
        textIn = (EditText)view.findViewById(R.id.textin);
        buttonAdd = (Button)view.findViewById(R.id.add);
        removebtn = (Button)view.findViewById(R.id.btnremove);
        createpdf = (Button)view.findViewById(R.id.createpdf);
        openpdf = (Button)view.findViewById(R.id.openpdf);

        container = (LinearLayout)view.findViewById(R.id.container);

        buttonAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {


                removebtn.setVisibility(View.VISIBLE);

                removebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        buttonAdd.setVisibility(View.INVISIBLE);
                        textIn.setVisibility(View.INVISIBLE);
                        removebtn.setVisibility(View.INVISIBLE);



                    }
                });

                if(textIn.getText().toString().isEmpty()){
                    Toast.makeText(context.getApplicationContext(),"Must Be Insert Data",Toast.LENGTH_SHORT).show();
                }
                else{
                    createpdf.setVisibility(View.VISIBLE);
                    openpdf.setVisibility(View.VISIBLE);

                    N = Integer.parseInt(textIn.getText().toString());
                    final EditText[] texts = new EditText[N];

                    for( i=0;i<N;i++){
                        text= new EditText(parent.getContext());
                        text.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View view) {



                                for(j=0;j<N;j++){
                                    if(j<N) {

                                        ((LinearLayout) addView.getParent()).removeViewAt(j);
                                        u--;
                                        Toast.makeText(parent.getContext(),"Remove Text Success",Toast.LENGTH_SHORT).show();

                                        return true;

                                    }

                                }


                                return  false;
                            }


                        });


                        LayoutInflater layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        addView = layoutInflater.inflate(R.layout.row, null);
                        container.addView(text);
                        text.setBackgroundColor(Color.WHITE);
                        text.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.style3));

                        text.setHint("insert text as you like ");
                        text.setPadding(20,30,20,20);
                        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        buttonLayoutParams.setMargins(2, 20, 90, 0);



                        text.setLayoutParams(buttonLayoutParams);

                        texts[i]=textIn;


                    }

                    container.addView(addView);
                    textIn.setText("");

                }


            }});


        createpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Document document = new Document(PageSize.LETTER, -20, 50, -15, 0);

                String outpath = Environment.getExternalStorageDirectory()+"/application.pdf";


                Toast.makeText(context.getApplicationContext(),outpath,Toast.LENGTH_LONG).show();

                try {



                    PdfWriter.getInstance(document,new FileOutputStream(outpath));


                    List<EditText>editTextList=new ArrayList<EditText>();

                    document.open();

                    Paragraph paragraph = new Paragraph();
                    paragraph.setIndentationLeft(30);
                    paragraph.setSpacingBefore(30);
                    document.add(Chunk.NEWLINE);
                    document.add(Chunk.NEWLINE);

                    paragraph.add(personalappliactionmodel.PERSONAL_DETAILS + Chunk.NEWLINE+ Chunk.NEWLINE);



                    paragraph.add(personalappliactionmodel.FIRST_NAME + " " + " " + " " + " "  + " " + " "
                            + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " " + " " + " " + " " + " ");


                    paragraph.add(personalappliactionmodel.MIDDLE_NAME + " " + " " + " " + " "  + " " + " "
                            + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " " + " " + " " + " " + " ");


                    paragraph.add(personalappliactionmodel.LAST_NAME + Chunk.NEWLINE+ Chunk.NEWLINE);


                    paragraph.add(personalappliactionmodel.ADDRESS + Chunk.NEWLINE+ Chunk.NEWLINE);


                    paragraph.add(personalappliactionmodel.DATE + " " + " " + " " + " "  + " " + " "
                            + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " "+ " " + " " + " " + " "+ " " );


                    paragraph.add( personalappliactionmodel.PHONE + Chunk.NEWLINE+ Chunk.NEWLINE);



                    paragraph.add(personalappliactionmodel.CITY + " " + " " + " " + " "  + " " + " "
                            + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " "+ " " + " " + " " + " "+ " " + " " + " "
                    );





                    paragraph.add(personalappliactionmodel.Gender + " " + " " + " " + " "  + " " + " "
                            + " " + " " + " "
                    );



                    paragraph.add(personalappliactionmodel.MALE + " " + " " + " " + " "  + " " + " "
                            + " " + " " + " " + " " + " " + " "
                            + " " + " " + " " + " " );



                    paragraph.add(personalappliactionmodel.FEMALE);




                    document.add(paragraph);

                    setBackground(document);


                    for (int m = 0; m <= N; m++) {


                        text = (EditText) container.getChildAt(m);
                        editTextList.add((text));

                        setBackground(document);


                        document.add(new Paragraph(Chunk.NEWLINE +
                                " " + " " + " " + " " + " " + " " + " " +

                                " " + " " +

                                editTextList.get(m).getText().toString()+ Chunk.NEWLINE));

                    }
                    document.close();
                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }catch (IOException e) {
                    e.printStackTrace();
                }
                document.close();

            }
        });
        openpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"/application.pdf");


                if (file.exists())
                {
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    Uri uri = Uri.fromFile(file);
                    intent.setDataAndType(uri, "application/pdf");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    try
                    {
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        context.getApplicationContext().startActivity(intent);
                    }
                    catch(ActivityNotFoundException e)
                    {
                        Toast.makeText(context.getApplicationContext(), "No Application available to view pdf", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });


        return new detailsfragmentthree_rececleeview.Holder(view);
    }

    @Override
    public void onBindViewHolder(detailsfragmentthree_rececleeview.Holder holder, int position) {

        personalappliactionmodel personalappliactionmodel =personalappliactionmodels.get(position);

        holder.fname.setText(personalappliactionmodel.fname);
        holder.mname.setText(personalappliactionmodel.mname);
        holder.lname.setText(personalappliactionmodel.lname);
        holder.address.setText(personalappliactionmodel.address);
        holder.phone.setText(personalappliactionmodel.phone);
        holder.date.setText(personalappliactionmodel.date);
        holder.city.setText(personalappliactionmodel.city);

    }

    @Override
    public int getItemCount() {
        return personalappliactionmodels.size();
    }


    public class Holder extends RecyclerView.ViewHolder{

        TextView fname,mname,lname,address,date,phone,city;
        public Holder(View itemView) {
            super(itemView);

            fname=(TextView)itemView.findViewById(R.id.fname);
            mname=(TextView)itemView.findViewById(R.id.mname);
            lname=(TextView)itemView.findViewById(R.id.lname);
            address=(TextView)itemView.findViewById(R.id.address);
            date=(TextView)itemView.findViewById(R.id.date);
            phone=(TextView)itemView.findViewById(R.id.phone);
            city=(TextView)itemView.findViewById(R.id.city);

        }
    }

    private void setBackground(Document document) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.hveeveve);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        Image img;
        try {
            img = Image.getInstance(stream.toByteArray());
            img.setAbsolutePosition(-20, 0);

            document.add(img);


        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }



}
