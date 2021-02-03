import { Edit, PasswordInput, SimpleForm, TextInput, useTranslate } from "react-admin";
import * as React from "react";

const EditAdministrators = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false}>
        <SimpleForm optionValue={"id"}>
            <TextInput label={t('custom.firstName')} source="firstName" />
            <TextInput label={t('custom.lastName')} source="lastName" />
            <TextInput label={t('custom.mail')} source="mail" />
            <TextInput label={t('custom.phone')} source="phone" />
            <PasswordInput label={t('custom.password')} source="password" />
        </SimpleForm>
    </Edit>
}

export default EditAdministrators