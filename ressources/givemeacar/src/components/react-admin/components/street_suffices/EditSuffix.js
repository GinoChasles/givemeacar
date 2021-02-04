import { Edit, SimpleForm, TextInput, useTranslate } from "react-admin";
import * as React from "react";

import Name from '../form/name';

const EditSuffix = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>
            <Name />
        </SimpleForm>
    </Edit>
}

export default EditSuffix