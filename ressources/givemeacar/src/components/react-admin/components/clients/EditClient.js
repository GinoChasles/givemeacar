import {AutocompleteInput, Edit, PasswordInput, ReferenceInput, SimpleForm, TextInput} from "react-admin";
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

            <ReferenceInput source="address_id" reference="addresses">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>

            <ReferenceInput source="user_status_id" reference="user_statuses">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>

            <ReferenceInput source="bill_id" reference="bills">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>

            <ReferenceInput source="agency_id" reference="agencies">
                <AutocompleteInput optionText="name" optionValue={"id"}/>
            </ReferenceInput>
        </SimpleForm>
        {/* </TabbedShowLayout> */}
    </Edit>
);

export default EditClient