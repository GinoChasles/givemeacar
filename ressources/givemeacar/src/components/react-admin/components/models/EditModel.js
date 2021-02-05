import {
    Edit, SimpleForm, useTranslate
} from "react-admin";
import * as React from "react";

import Name from '../form/name';
import Brand from '../form/brand';

const EditModel = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>

            <Brand />

            <Name />

        </SimpleForm>
    </Edit>
}
export default EditModel