import {
    Datagrid, Filter, List, SearchInput, TextField, useTranslate, EditButton, DeleteButton
} from "react-admin";
import * as React from "react";

const EnergyTypeFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayEnergyType = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.energyTypes')} filters={<EnergyTypeFilter />} exporter={false} perPage={25}>
        <Datagrid hasBulkActions rowClick="show">
            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.name')} source="name" />
        </Datagrid>

        <EditButton />

        <DeleteButton />
    </List>
}

export default DisplayEnergyType