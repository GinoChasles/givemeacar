import { Datagrid, Filter, List, SearchInput, TextField, ReferenceField, useTranslate, EditButton, DeleteButton } from "react-admin";
import * as React from "react";

import ShowAgency from './ShowAgency';

const AgencyFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayAgency = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.agencies')} filters={<AgencyFilter />} exporter={false} perPage={25}>
        <Datagrid hasBulkActions rowClick="show" expand={ShowAgency}>

            <TextField source="id" label={t("word.id")} />

            <TextField source="name" label={t("word.name")} />

            <TextField source="cityName" label={t("word.city")} />

            <ReferenceField label={t('word.manager')} source="manager_id" reference="managers" link="show">
                <TextField source="fullName" />
            </ReferenceField>


            <DeleteButton />

        </Datagrid>
    </List>
}

export default DisplayAgency