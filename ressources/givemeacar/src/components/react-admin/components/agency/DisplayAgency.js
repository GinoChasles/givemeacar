import { Datagrid, Filter, List, SearchInput, TextField, useTranslate, EditButton, DeleteButton } from "react-admin";
import * as React from "react";

const AgencyFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayAgency = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.agencies')} filters={<AgencyFilter />} exporter={false} perPage={25}>
        <Datagrid hasBulkActions rowClick="show">

            <TextField source="id" label={t("word.id")} />

            <TextField source="name" label={t("word.name")} />

            <TextField source="address" label={t("word.address")} />

            <EditButton />

            <DeleteButton />
        </Datagrid>
    </List>
}

export default DisplayAgency