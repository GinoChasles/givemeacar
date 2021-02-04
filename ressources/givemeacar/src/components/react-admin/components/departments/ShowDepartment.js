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

            <TextField label={t('custom.code')} source="code" />

            <TextField label={t('custom.name')} source="name" />

            <ReferenceField label={t('custom.region')} source="region_id" reference="regions">
                <TextField source="name" />
            </ReferenceField>

        </SimpleShowLayout>
    </Show>
}

export default ShowDepartment;
