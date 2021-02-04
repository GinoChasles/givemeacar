import {
    AutocompleteInput, Edit, PasswordInput, ReferenceInput, SimpleForm, TextInput, useTranslate
} from "react-admin";
import * as React from "react";

const EditManager = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('custom.edition')}>
        <SimpleForm>
            <ReferenceInput label={t('custom.agency')} source="agency_id" reference="agencies">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

            <TextInput label={t('custom.firstName')} source="firstName" />

            <TextInput label={t('custom.lastName')} source="lastName" />

            <TextInput label={t('custom.mail')} source="mail" />

            <TextInput label={t('custom.phone')} source="phone" />

            <PasswordInput label={t('custom.password')} source="password" />
        </SimpleForm>
    </Edit>
}

export default EditManager