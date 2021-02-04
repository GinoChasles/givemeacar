import {
    AutocompleteInput, Edit, ReferenceInput, SimpleForm, TextInput, useTranslate
} from "react-admin";
import * as React from "react";

const EditDepartments = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('custom.edition')}>
        <SimpleForm>
            <ReferenceInput label={t('custom.region')} source="region_id" reference="regions">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

            <TextInput label={t('custom.code')} source="code" />

            <TextInput label={t('custom.name')} source="name" />
        </SimpleForm>
    </Edit>
}

export default EditDepartments