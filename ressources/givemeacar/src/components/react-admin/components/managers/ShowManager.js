import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
    EmailField,
    ReferenceField,

} from "react-admin";


const ShowDepartment = (props) => {

    const t = useTranslate();

    return <Show {...props}>
        <SimpleShowLayout>
            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.firstName')} source="firstName" />

            <TextField label={t('custom.lastName')} source="lastName" />

            <EmailField label={t('custom.mail')} source="mail" />

            <TextField label={t('custom.phone')} source="phone" />

            <ReferenceField link='show' label={t('custom.agency')} source="agency_id" reference="agencies">
                <TextField source="name" />
            </ReferenceField>
        </SimpleShowLayout>
    </Show>
}

export default ShowDepartment;
