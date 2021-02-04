import { Edit, SimpleForm, TextInput, useTranslate } from "react-admin";

import * as React from "react";

const EditRegion = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('custom.edition')}>
        <SimpleForm>
            <TextInput label={t('custom.name')} source="name" />
        </SimpleForm>
    </Edit>
}

export default EditRegion