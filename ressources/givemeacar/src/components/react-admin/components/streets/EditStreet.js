import {AutocompleteInput, Edit, ReferenceInput, SimpleForm} from "react-admin";
import * as React from "react";

const EditStreet = (props) => (
    <Edit {...props}>
        <SimpleForm>
            <ReferenceInput source="city_id" reference="cities">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>
            <ReferenceInput source="street_name_id" reference="street_names">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>
        </SimpleForm>
    </Edit>
);
export default EditStreet