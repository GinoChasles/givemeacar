import { AutocompleteInput, Edit, ReferenceInput, SimpleForm, TextInput, NumberInput } from "react-admin";
import * as React from "react";

const EditAgency = (props) => (
    <Edit {...props} undoable={false}>
        <SimpleForm>
            <TextInput source="name" />

            <NumberInput source="streetNumber" />

            <ReferenceInput source="street_suffix_id" reference="street_suffices">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

            <ReferenceInput source="street_id" reference="streets">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

            <ReferenceInput source="city_id" reference="cities">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

        </SimpleForm>
    </Edit>
);

export default EditAgency