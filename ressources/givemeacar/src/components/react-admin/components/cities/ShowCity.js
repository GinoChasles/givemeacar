import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
    ReferenceField

} from "react-admin";


const ShowCity = (props) => {

    const t = useTranslate();

    return <Show {...props}>
        <SimpleShowLayout>
            <TextField label={t('custom.id')} source="id" />
            <TextField label={t('custom.name')} source="name" />
            <TextField label={t('custom.zipcode')} source="zipcode" />
            <ReferenceField link="show" label={t('custom.department')} source="department_id" reference="departments">
                <TextField source="name" />
            </ReferenceField>
            <ReferenceField link="show" label={t('custom.region')} source="regionId" reference="regions">
                <TextField source="name" />
            </ReferenceField>
        </SimpleShowLayout>
    </Show>
}

export default ShowCity;
