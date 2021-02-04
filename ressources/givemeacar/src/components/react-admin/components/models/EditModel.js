import {
    AutocompleteInput, Edit, ReferenceInput, SimpleForm, TextInput, useTranslate
} from "react-admin";
import * as React from "react";

const EditModel = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('custom.edition')}>
        <SimpleForm>
            <ReferenceInput label={t('custom.brand')} source="brand_id" reference="brands">
                <AutocompleteInput optionText="name" optionValue={"id"} />

            </ReferenceInput>
            <TextInput label={t('custom.name')} source="name" />
        </SimpleForm>
    </Edit>
}
export default EditModel