import * as React from "react";

import { Edit, SimpleForm, useTranslate } from "react-admin";

import Name from '../form/name';

const EditBrand = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>

            <Name />

        </SimpleForm>
    </Edit>
}

export default EditBrand