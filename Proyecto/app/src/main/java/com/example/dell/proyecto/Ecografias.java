package com.example.dell.proyecto;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dell.dao.CitasDao;
import com.example.dell.dao.EcografiasDao;
import com.example.dell.modelo.ModelCitas;
import com.example.dell.modelo.ModelEcografias;

import java.util.Date;

/**
 * Created by Dell on 24/10/2016.
 */
public class Ecografias extends Fragment {

    View myView;
    EcografiasDao ecografiasDao;
    Spinner spinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_ecografias, container, false);
        ecografiasDao = new EcografiasDao(myView.getContext());

        String mes[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        ArrayAdapter adapter = new ArrayAdapter(myView.getContext(), android.R.layout.simple_spinner_dropdown_item, mes);
        spinner = (Spinner) myView.findViewById(R.id.spinnerMes);
        spinner.setAdapter(adapter);

        Button botonGuardar = (Button) myView.findViewById(R.id.btnGuardarEcografia);
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ModelEcografias modelEcografias = new ModelEcografias();
                    EditText edtImagen = (EditText) myView.findViewById(R.id.editImagen);
                    String mes = spinner.getSelectedItem().toString();
                    modelEcografias.setImagen(edtImagen.getText().toString());
                    modelEcografias.setMes(Integer.parseInt(mes));
                    modelEcografias.setIdCita(1);
                   
                    int id = ecografiasDao.agregarEcografia(modelEcografias);

                    Toast toast = Toast.makeText(myView.getContext(), "Registro almacenado con exito, id = "+id, Toast.LENGTH_SHORT);
                    toast.show();
                } catch (Exception e) {
                    Toast toast = Toast.makeText(myView.getContext(), "Error " + e.getMessage(), Toast.LENGTH_SHORT);
                    toast.show();
                }


            }
        });
        return myView;
    }
}
