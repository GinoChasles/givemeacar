import { AutocompleteInput, Edit, PasswordInput, ReferenceInput, SimpleForm, TextInput, NumberInput } from "react-admin";
import * as React from "react";

const EditClient = (props) => (
    <Edit {...props} undoable={false}>
        {/* <TabbedShowLayout> */}
        <SimpleForm>
            <TextInput source="firstName" />
            <TextInput source="lastName" />
            <TextInput source="mail" />
            <PasswordInput source="password" />
            <TextInput source="phone" />

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

            <ReferenceInput source="agency_id" reference="agencies">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>
        </SimpleForm>
        {/* </TabbedShowLayout> */}
    </Edit>
);

export default EditClient