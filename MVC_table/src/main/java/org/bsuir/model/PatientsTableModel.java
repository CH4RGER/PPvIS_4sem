package org.bsuir.model;

import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.util.*;

public class PatientsTableModel extends DefaultTableModel {

    public PatientsTableModel() {

        super(Parameters.defaultData, Parameters.TABLE_HEADER);
    }

    public void addPatient(Patient patient) {

        addRow(parsePatient(patient));
        System.out.println("Added patient");
    }

    /**
     * @param fullName surname of the patient to remove
     * @param address  address of the patient to remove
     * @return amount of removed patients
     */
    public int deleteByFullNameOrAddress(String fullName, String address) {

        int counter = 0;

        for (int i = 0; i < getRowCount(); ++i) {
            if (getValueAt(i, 1).equals(address)
                    || getValueAt(i, 0).equals(fullName)) {

                ++counter;
                removeRow(i--);
            }
        }
        System.out.println("Removed " + counter + " patients");

        return counter;
    }

    /**
     * @param birthday the date to remove patients
     * @return amount of deleted patients
     */
    public int deleteByBirthday(DateManager birthday) {
        int counter = 0;
        String date = birthday.toString();

        for (int i = 0; i < getRowCount(); ++i) {

            if (getValueAt(i, 2).equals(date)) {
                ++counter;
                removeRow(i--);
            }
        }
        System.out.println("Removed " + counter + "patients");

        return counter;
    }

    private Object[] parsePatient(Patient patient) {

        Object[] objects = new Object[6];
        objects[0] = patient.getFullName();
        objects[1] = patient.getPlaceOfResidence();
        objects[2] = patient.getBirthday().toString();
        objects[3] = patient.getDateOfReceipt().toString();
        objects[4] = patient.getDoctorsFullName();
        objects[5] = patient.getConclusion();
        return objects;
    }

    public int deleteByDoctorsFullNameOrDateReceipt(String doctorsFullName, DateManager dateOfReceipt) {
        int counter = 0;
        String date = dateOfReceipt.toString();

        for (int i = 0; i < getRowCount(); ++i) {

            if (getValueAt(i, 3).equals(date)
                    || getValueAt(i, 4).equals(doctorsFullName)) {

                ++counter;
                removeRow(i--);
            }
        }
        System.out.println("Deleted " + counter + " patients");

        return counter;
    }

    public PatientsTableModel createSubModelByFullNameAndAddress(String fullName, String address) throws ArrayIndexOutOfBoundsException {
        PatientsTableModel model = new PatientsTableModel();

        for (int i = 0; i < getRowCount(); ++i) {
            if (getValueAt(i, 1).equals(address)
                    || getValueAt(i, 0).equals(fullName)) {

                model.addRow(parseRowToObjects(i));
            }
        }
        return model;
    }

    public PatientsTableModel createSubModelByBirthday(DateManager birthday) throws ArrayIndexOutOfBoundsException {
        PatientsTableModel model = new PatientsTableModel();

        String parsedBirthday = birthday.toString();

        for (int i = 0; i < getRowCount(); ++i) {

            if (getValueAt(i, 2).equals(parsedBirthday)) {
                model.addRow(parseRowToObjects(i));

            }
        }
        return model;
    }

    public PatientsTableModel createSubModelByDoctorsFullNameOrDateReceipt(String doctorsFullName,
                                                                           DateManager dateOfReceipt) throws ArrayIndexOutOfBoundsException {

        PatientsTableModel model = new PatientsTableModel();
        String date = dateOfReceipt.toString();

        for (int i = 0; i < getRowCount(); ++i) {

            if (getValueAt(i, 3).equals(date)
                    || getValueAt(i, 4).equals(doctorsFullName)) {

                model.addRow(parseRowToObjects(i));

            }
        }
        return model;
    }

    public PatientsTableModel createPagedSubModel(int page, int amountOfDataOnThePage)
            throws ArrayIndexOutOfBoundsException {

        PatientsTableModel subModel = new PatientsTableModel();

        int currentRowNumber = (page - 1) * amountOfDataOnThePage;
        int lastRowNumber = (page) * amountOfDataOnThePage;

        int totalNumberOfLines = getRowCount();

        if (lastRowNumber > totalNumberOfLines)
            lastRowNumber = totalNumberOfLines;

        for (; currentRowNumber < lastRowNumber; ++currentRowNumber) {

            subModel.addRow(parseRowToObjects(currentRowNumber));
        }

        return subModel;
    }

    private Patient getPatient(int rowNumber) throws ParseException {
        Object[] objects = parseRowToObjects(rowNumber);
        return new Patient((String) objects[0], (String) objects[1], new DateManager((String) objects[2]),
                new DateManager((String) objects[3]), (String) objects[4], (String) objects[5]);
    }

    private Object[] parseRowToObjects(int rowNumber) {
        //FIXME bad code :(
        Vector<Vector> tableData = getDataVector();

        Vector data = tableData.elementAt(rowNumber);
        return data.toArray();
    }


    public List<Patient> getAllPatients() throws ParseException {
        List<Patient> allPatients = new ArrayList<>();
        for (int i = 0; i < getRowCount(); ++i) {
            allPatients.add(getPatient(i));
        }
        return allPatients;
    }

    public void resetModel(List<Patient> patients) {
        clearModel();
        for (Patient patient : patients) {
            addRow(parsePatient(patient));
        }
    }

    private void clearModel(){
        for(int i=0;i<getRowCount();++i){
            removeRow(i--);
        }
    }

}
