import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
    ReferenceField,

} from "react-admin";


const ShowModel = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('custom.description')}>
        <SimpleShowLayout>

            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.name')} source="name" />

            <ReferenceField label={t('custom.brand')} source="brand_id" reference="brands">
                <TextField source="name" />
            </ReferenceField>

        </SimpleShowLayout>
    </Show>
}

export default ShowModel;
