import {AutocompleteInput, DateTimeInput, Edit, ReferenceInput, SimpleForm} from "react-admin";
import * as React from "react";

const EditRent = (props) => (
    <Edit {...props} undoable={false}>
        <SimpleForm>
            <DateTimeInput source="start" />
            <DateTimeInput source="end" />
            <ReferenceInput source="car_id" reference="cars">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>
            <ReferenceInput source="client_id" reference="clients">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>
        </SimpleForm>
    </Edit>
);
export default EditRent