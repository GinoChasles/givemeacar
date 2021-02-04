import { Edit, SimpleForm, useTranslate } from "react-admin";
import * as React from "react";

import City from '../form/city';
import Street from '../form/street';
import Suffix from '../form/suffix';
import Name from '../form/name';
import StreetNumber from '../form/streetNumber';

const EditAgency = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>
            
            <Name />
            <StreetNumber />
            <Suffix />
            <Street />
            <City />

        </SimpleForm>
    </Edit>
}

export default EditAgency