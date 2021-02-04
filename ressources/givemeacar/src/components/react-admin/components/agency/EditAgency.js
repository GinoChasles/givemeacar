import { AutocompleteInput, Edit, ReferenceInput, SimpleForm, TextInput, NumberInput, useTranslate } from "react-admin";
import * as React from "react";

const EditAgency = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('custom.edition')}>
        <SimpleForm>
            <TextInput label={t('custom.name')} source="name" />

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

        </SimpleForm>
    </Edit>
}

export default EditAgency