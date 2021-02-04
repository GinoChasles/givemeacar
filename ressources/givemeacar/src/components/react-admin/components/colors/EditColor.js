import { Edit, SimpleForm, TextInput, useTranslate } from "react-admin";
import * as React from "react";

const EditColor = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('custom.edition')}>
        <SimpleForm>
            <TextInput source="name" />
        </SimpleForm>
    </Edit>
}

export default EditColor