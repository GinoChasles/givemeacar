import {AutocompleteInput, BooleanInput, Edit, NumberInput, ReferenceInput, SimpleForm} from "react-admin";
import * as React from "react";

const EditCar = (props) => (
    <Edit {...props} undoable={false}>
        <SimpleForm>
            <NumberInput source="kilometers" />
            <NumberInput source="price" />
            <NumberInput source="year" />
            <BooleanInput source="available" valueLabelTrue="La voiture est dispo" valueLabelFalse="la voiture est indisponible"/>
            <BooleanInput source="rented" valueLabelTrue="la voiture est louée" valueLabelFalse="la voiture n'est pas louée" />
            <ReferenceInput source="model_id" reference="models">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>
            <ReferenceInput source="color_id" reference="colors">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>
            <NumberInput source="energy_max" />
            <NumberInput source="energy_current" />
            <ReferenceInput source="energy_type_id" reference="energy_types">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>
            <NumberInput source="latitude" />
            <NumberInput source="longitude" />
        </SimpleForm>
    </Edit>
);

export default EditCar