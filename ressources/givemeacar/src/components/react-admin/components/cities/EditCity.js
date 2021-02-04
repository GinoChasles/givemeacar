import { AutocompleteInput, Edit, NumberInput, ReferenceInput, SimpleForm, TextInput, useTranslate } from "react-admin";
import * as React from "react";

const EditCity = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false}>
        <SimpleForm>

            <TextInput label={t('custom.zipcode')} source="zipcode" />

            <TextInput label={t('custom.name')} source="name" />

            <NumberInput label={t('custom.latitude')} source="latitude" />

            <NumberInput label={t('custom.longitude')} source="longitude" />

            <ReferenceInput label={t('custom.department')} source="department_id" reference="departments">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>
        </SimpleForm>
    </Edit>
}

export default EditCity