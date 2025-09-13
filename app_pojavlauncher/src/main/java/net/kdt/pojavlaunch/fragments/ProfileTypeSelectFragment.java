package net.kdt.pojavlaunch.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import git.artdeell.mojo.R;
import net.kdt.pojavlaunch.Tools;
import net.kdt.pojavlaunch.instances.Instance;
import net.kdt.pojavlaunch.instances.InstanceManager;

import java.io.IOException;

public class ProfileTypeSelectFragment extends Fragment {
    public static final String TAG = "ProfileTypeSelectFragment";
    public ProfileTypeSelectFragment() {
        super(R.layout.fragment_profile_type);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.vanilla_profile).setOnClickListener(v -> {
            try {
                Instance instance = InstanceManager.createDefaultInstance();
                InstanceManager.setSelectedInstance(instance);
                Tools.swapFragment(requireActivity(), InstanceEditorFragment.class,
                        InstanceEditorFragment.TAG, new Bundle(1));
            }catch (IOException e) {
                Tools.showError(view.getContext(), e);
            }
        });

        // NOTE: Special care needed! If you wll decide to add these to the back stack, please read
        // the comment in FabricInstallFragment.onDownloadFinished() and amend the code
        // in FabricInstallFragment.onDownloadFinished() and ModVersionListFragment.onDownloadFinished()
        view.findViewById(R.id.optifine_profile).setOnClickListener(v -> Tools.swapFragment(requireActivity(), OptiFineInstallFragment.class,
                OptiFineInstallFragment.TAG, null));
        view.findViewById(R.id.modded_profile_fabric).setOnClickListener((v)->
                Tools.swapFragment(requireActivity(), FabricInstallFragment.class, FabricInstallFragment.TAG, null));
        view.findViewById(R.id.modded_profile_forge).setOnClickListener((v)->
                Tools.swapFragment(requireActivity(), ForgeInstallFragment.class, ForgeInstallFragment.TAG, null));
        view.findViewById(R.id.modded_profile_modpack).setOnClickListener((v)->
                Tools.swapFragment(requireActivity(), SearchModFragment.class, SearchModFragment.TAG, null));
        view.findViewById(R.id.modded_profile_quilt).setOnClickListener((v)->
                Tools.swapFragment(requireActivity(), QuiltInstallFragment.class, QuiltInstallFragment.TAG, null));
        view.findViewById(R.id.modded_profile_bta).setOnClickListener((v)->
                Tools.swapFragment(requireActivity(), BTAInstallFragment.class, BTAInstallFragment.TAG, null));
        view.findViewById(R.id.modded_profile_neoforge).setOnClickListener((v)->
                Tools.swapFragment(requireActivity(), NeoforgeInstallFragment.class, NeoforgeInstallFragment.TAG, null));
    }
}
