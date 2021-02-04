import {
    Edit, SimpleForm, useTranslate
} from "react-admin";
import * as React from "react";

import Name from '../form/name';
import Code from '../form/code';
import Region from '../form/region';

const EditDepartments = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>

            <Region />

            <Code />

            <Name />

        </SimpleForm>
    </Edit>
}

export default EditDepartments