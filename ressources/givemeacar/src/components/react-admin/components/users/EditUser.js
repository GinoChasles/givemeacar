import { AutocompleteInput, Edit, PasswordInput, ReferenceInput, SimpleForm, TextInput, NumberInput, useTranslate } from "react-admin";
import * as React from "react";

const EditUser = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('custom.edition')}>
        {/* <TabbedShowLayout> */}
        <SimpleForm>

            <TextInput label={t('custom.firstName')} source="firstName" />

            <TextInput label={t('custom.lastName')} source="lastName" />

            <TextInput label={t('custom.mail')} source="mail" />

            <PasswordInput label={t('custom.password')} source="password" />

            <TextInput label={t('custom.phone')} source="phone" />

            <NumberInput label={t('custom.number')} source="streetNumber" />

            <ReferenceInput label={t('custom.suffix')} source="street_suffix_id" reference="street_suffices">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

            <ReferenceInput label={t('custom.street')} source="street_id" reference="streets">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

            <ReferenceInput label={t('custom.city')} source="city_id" reference="cities">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

            <ReferenceInput label={t('custom.agency')} source="agency_id" reference="agencies">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

        </SimpleForm>
        {/* </TabbedShowLayout> */}
    </Edit>
}

export default EditUser;