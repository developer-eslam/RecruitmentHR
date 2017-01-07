package com.erp.recruitmentmanagment.recruitmentsystem.themesfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.erp.recruitmentmanagment.recruitmentsystem.R;
import com.erp.recruitmentmanagment.recruitmentsystem.educations.educationthemefive;
import com.erp.recruitmentmanagment.recruitmentsystem.experience.expeiencethemefive;
import com.erp.recruitmentmanagment.recruitmentsystem.other.otherthemefive;
import com.erp.recruitmentmanagment.recruitmentsystem.personalapplcation.personalappthemefive;
import com.erp.recruitmentmanagment.recruitmentsystem.skills.skillsthemefive;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThemeFiveFragment extends Fragment {


    Button personalappliaction;
    Button education;
    Button experience;
    Button skills;
    Button other;
    Button compine;
    public ThemeFiveFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_theme_five, container, false);
        personalappliaction=(Button)view.findViewById(R.id.personalapp);
        education=(Button)view.findViewById(R.id.educations);
        experience=(Button)view.findViewById(R.id.experience);
        skills=(Button)view.findViewById(R.id.skills);
        other=(Button)view.findViewById(R.id.other);
        compine=(Button)view.findViewById(R.id.compine);
        personalappliaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),personalappthemefive.class));
            }
        });
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),educationthemefive.class));

            }
        });
        experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),expeiencethemefive.class));

            }
        });
        skills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),skillsthemefive.class));

            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),otherthemefive.class));

            }
        });
        compine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<InputStream> pdfs = new ArrayList<InputStream>();

                try {
                    pdfs.add(new FileInputStream("/storage/emulated/0/application.pdf"));
                    pdfs.add(new FileInputStream("/storage/emulated/0/educations.pdf"));
                    pdfs.add(new FileInputStream("/storage/emulated/0/experience.pdf"));
                    pdfs.add(new FileInputStream("/storage/emulated/0/skill.pdf"));
                    pdfs.add(new FileInputStream("/storage/emulated/0/other.pdf"));

                    OutputStream output = new FileOutputStream("/storage/emulated/0/RecruitmentApplication.pdf");
                    Toast.makeText(getContext(),""+ output,Toast.LENGTH_LONG).show();
                    concatPDFs(pdfs,output);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public  void concatPDFs(List<InputStream> streamOfPDFFiles,
                            OutputStream outputStream) {

        Document document = new Document(PageSize.LETTER, -40, -15, -15, 5);

        try {
            List<InputStream> pdfs = streamOfPDFFiles;
            List<PdfReader> readers = new ArrayList<PdfReader>();
            int totalPages = 0;
            Iterator<InputStream> iteratorPDFs = pdfs.iterator();

            // Create Readers for the pdfs.
            while (iteratorPDFs.hasNext()) {
                InputStream pdf = iteratorPDFs.next();
                PdfReader pdfReader = new PdfReader(pdf);
                readers.add(pdfReader);
                totalPages += pdfReader.getNumberOfPages();
            }

            // Create a writer for the outputstream
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();


            // Holds the PDF data
            PdfContentByte cb = writer.getDirectContent();

            PdfImportedPage page;
            int currentPageNumber = 0;
            int pageOfCurrentReaderPDF = 0;
            Iterator<PdfReader> iteratorPDFReader = readers.iterator();

            // Loop through the PDF files and add to the output.
            while (iteratorPDFReader.hasNext()) {
                PdfReader pdfReader = iteratorPDFReader.next();

                // Create a new page in the target for each source page.
                while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {
                    document.newPage();
                    pageOfCurrentReaderPDF++;
                    currentPageNumber++;
                    page = writer.getImportedPage(pdfReader,pageOfCurrentReaderPDF);
                    cb.addTemplate(page, 0, 0);


                }
                pageOfCurrentReaderPDF = 0;
            }
            outputStream.flush();
            document.close();
            outputStream.close();
        }

        catch (Exception e) {
            System.err.println("Exception : " + e.getMessage());
        }

        finally {
            if (document.isOpen())
                document.close();

            try {
                if (outputStream != null)
                    outputStream.close();
            }

            catch (IOException ioe) {
                System.err.println("Exception : " + ioe.getMessage());
            }
        }
    }

}


