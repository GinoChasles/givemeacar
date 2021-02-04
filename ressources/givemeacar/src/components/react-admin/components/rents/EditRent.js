import {
    DateTimeInput, Edit, SimpleForm, useTranslate
} from "react-admin";
import * as React from "react";

import Client from '../form/client';
import Car from '../form/car';

const EditRent = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm>
            
            <DateTimeInput label={t('word.rentStart')} source="start" validate={[
                required()
            ]} />

            <DateTimeInput label={t('word.rentEnd')} source="end" validate={[
                required()
            ]} />

            <Car />

            <Client />

        </SimpleForm>
    </Edit>
}

export default EditRent