import { Edit, SimpleForm, useTranslate } from "react-admin";
import * as React from "react";

import Name from '../form/name'
import Latitude from '../form/latitude'
import Longitude from '../form/longitude'
import Department from '../form/department'
import Zipcode from '../form/zipcode'

const EditCity = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>

            <Zipcode />

            <Name />

            <Latitude />

            <Longitude />

            <Department />

        </SimpleForm>
    </Edit>
}

export default EditCity