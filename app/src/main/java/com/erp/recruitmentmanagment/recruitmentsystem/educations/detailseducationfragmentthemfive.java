package com.erp.recruitmentmanagment.recruitmentsystem.educations;

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
 * Created by abotaleb on 12/14/2016.
 */

public class detailseducationfragmentthemfive extends RecyclerView.Adapter<detailseducationfragmentthemfive.Holder> {


    EditText textIn;
    Button buttonAdd;
    Button removebtn;
    Button  createpdf;
    Button  openpdf;
    LinearLayout container;
    private List<educationmodel> educationmodels;
    Context context;
    EditText text;
    View addView;
    int j=0;
    int N;
    int u = 0;
    int i;
    public detailseducationfragmentthemfive( Context context,List<educationmodel>educationmodels){
        this.educationmodels=educationmodels;
        this.context = context;

    }

    @Override
    public detailseducationfragmentthemfive.Holder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_detailseducationfragmentthemefive,parent,false);

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
                    text.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.style5));

                    text.setHint("insert text as you like ");
                    text.setPadding(20,30,20,20);
                    LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    buttonLayoutParams.setMargins(2, 20, 90, 0);



                    text.setLayoutParams(buttonLayoutParams);

                    texts[i]=textIn;


                }

                container.addView(addView);
                textIn.setText("");

            }});


        createpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Document document = new Document(PageSize.LETTER, -20, 50, -15, 0);

                String outpath = Environment.getExternalStorageDirectory()+"/educations.pdf";

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

                    paragraph.add("Educations"+ Chunk.NEWLINE+ Chunk.NEWLINE );

                    paragraph.add(educationmodel.HIGH_SCHOOL + Chunk.NEWLINE+ Chunk.NEWLINE);



                    paragraph.add(educationmodel.Undergraduate_COLLAGE +Chunk.NEWLINE+ Chunk.NEWLINE);


                    paragraph.add(educationmodel.DEGREE_MAJOR +Chunk.NEWLINE+ Chunk.NEWLINE );

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

                    document.close();
                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        openpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"/educations.pdf");


                if (file.exists())
                {
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    Uri uri = Uri.fromFile(file);
                    intent.setDataAndType(uri, "/educations.pdf");
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


        return new detailseducationfragmentthemfive.Holder(view);
    }

    @Override
    public void onBindViewHolder(detailseducationfragmentthemfive.Holder holder, int position) {

        educationmodel educationmodel =educationmodels.get(position);

        holder.highschool.setText(educationmodel.high_school);
        holder.degreemajor.setText(educationmodel.degree_major);
        holder.undergraduate.setText(educationmodel.undergraduate_collage);



    }

    @Override
    public int getItemCount() {
        return educationmodels.size();
    }


    public class Holder extends RecyclerView.ViewHolder{

        TextView highschool,degreemajor,undergraduate;
        public Holder(View itemView) {
            super(itemView);

            highschool=(TextView)itemView.findViewById(R.id.highschool);
            degreemajor=(TextView)itemView.findViewById(R.id.degreemajor);
            undergraduate=(TextView)itemView.findViewById(R.id.undergraduatecollage);


        }
    }


    private void setBackground(Document document) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ugugu);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        Image img;
        try {
            img = Image.getInstance(stream.toByteArray());
            img.setAbsolutePosition(-20, 195);

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




