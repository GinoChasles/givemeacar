import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
    ReferenceField

} from "react-admin";


const ShowDepartment = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('custom.description')}>
        <SimpleShowLayout>
            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.name')} source="name" />
        </SimpleShowLayout>
    </Show>
}

export default ShowDepartment;
