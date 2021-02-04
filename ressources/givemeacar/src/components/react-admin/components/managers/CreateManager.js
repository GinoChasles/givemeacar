import * as React from "react";
import {
    Create,
    SimpleForm,
    ReferenceInput,
    AutocompleteInput,
    TextInput,
    PasswordInput,
    useTranslate
} from "react-admin";

const CreateManager = (props) => {

    const t = useTranslate();

    return <Create {...props} title={t('custom.creation')}>
        <SimpleForm >
            <ReferenceInput label={t('custom.agency')} source="agency_id" reference="agencies">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

            <TextInput label={t('custom.firstName')} source="firstName" />

            <TextInput label={t('custom.lastName')} source="lastName" />

            <TextInput label={t('custom.mail')} source="mail" />

            <TextInput label={t('custom.phone')} source="phone" />

            <PasswordInput label={t('custom.password')} source="password" />
        </SimpleForm>
    </Create>
}
export default CreateManager
